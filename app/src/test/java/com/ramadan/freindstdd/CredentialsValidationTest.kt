package com.ramadan.freindstdd

import com.ramadan.InstantTaskExecutorExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantTaskExecutorExtension::class)
class CredentialsValidationTest {
    @Test
    fun badEmail(){
        val viewModel = SignupViewModel()
        viewModel.createAccount("email",":password:" , ":about:")
        assertEquals(SignupState.BadEmail , viewModel.signupState.value)
    }
}