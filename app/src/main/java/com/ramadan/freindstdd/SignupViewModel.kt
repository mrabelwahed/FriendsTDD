package com.ramadan.freindstdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SignupViewModel {
    private var _mutableSignupState = MutableLiveData<SignupState>()
    val signupState: LiveData<SignupState> = _mutableSignupState

    fun createAccount(email: String, password: String, about: String) {
      _mutableSignupState.value = SignupState.BadEmail
    }

}
