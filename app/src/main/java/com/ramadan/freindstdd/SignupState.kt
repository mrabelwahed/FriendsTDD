package com.ramadan.freindstdd

sealed class SignupState {
 object BadEmail : SignupState()
 object BadPassword : SignupState()
}
