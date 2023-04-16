package c

import android.util.Log
import androidx.navigation.fragment.findNavController
import com.example.taskappakyl.R

()om.example.taskappakyl.ui.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.taskappakyl.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS


class AuthFragment : Fragment() {
    lateinit var binding: FragmentAuthBinding
    r auth = FirebaseAuth.getInstance()
    t correctorCode : String? = null
    erride fun onCreateView (
        inflater:LayoutInflater, container:ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAuthBinding.inflate (layouInflater)
        initListeners()
        return binding.root
    }
private fun initListeners() {
    binding.etPhoneFrt.setText("+996")
    binding.btnSave.setOnClickListener {
        if (binding.etPhonFrt.text!!.isNotEmpty()) {
            sendPhone()
            Toast.makeText(requireContext()), "отправка..."  Toast.LENGTH_SHORT).show()
        } else {
            binding.etPhoneFrt.error = "Введите номер телефона "
        }
    }
    binding.btnConfing.setOnClickListener {
        sendCode()
    }
}
    private  fun () {
        auth.setLanguageCode("en")
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(binding.etPhoneFrt.text.toString())
            .setTimeout(60L, TimeUnit,SECONDS)
            .setActivity(requireActivity())
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    Toast.makeText(requireContext() , "Успешно" ,  Toast.LENGTH_SHORT).show()
                }
                override fun onCodeSent(
                    vertificetionCode: String,
                    p1: PhoneAuthProvider.ForceResendingToken
                ) {
                    correctCode = vertificetionCode
                    binding.etPhoneLayoutFrt.isVisible = false
                    binding.btnSave.isvosoble = false

                    binding.etCodeLayout.isVisible = true
                    binding.btnConfirn.isVisible = true
                    super.CodeSent(vertificetionCode,p1)

                }

            })
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)

    }
    private fun sendCode() {
        val credential =
            PhoneAuthProvider.getCredential(
                correctCode.toString(), binding.etCode.text.toString()
            )
        singInWhithPhoneAuthCredential(credential)
    }
private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
    auth.signInWithCredential(credential)
        .addOnCompleteListener(requireActivity()) { task ->
            Log.w("ololo" , "signinWithCradential:failure", task.exception ) {
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.navigation_home)
                } else {
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        Toast.makeText(
                            requireContext(),
                            task.exception.toString(),
                            Toast.LENGTH_SHORT

                        ).show()
                    }

                }

            }
}
}