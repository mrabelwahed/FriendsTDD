package com.ramadan.freindstdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.regex.Pattern

class SignupViewModel {
    private var _mutableSignupState = MutableLiveData<SignupState>()
    val signupState: LiveData<SignupState> = _mutableSignupState

    fun createAccount(email: String, password: String, about: String) {
       val emailRegx =  """[a-zA-Z0-9+._%\-]{1,64}@[a-zA-Z0-9][a-zA-Z0-9\-]{1,64}(\.[a-zA-Z0-9][a-zA-Z0-9\-]{1,25})"""
        val pattern = Pattern.compile(emailRegx)
        if (!pattern.matcher(email).matches()){
            _mutableSignupState.value = SignupState.BadEmail
        }else if (password.isEmpty()){
            _mutableSignupState.value = SignupState.BadPassword
        }

    }

}
