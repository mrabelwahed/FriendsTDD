package com.ramadan.freindstdd

import com.ramadan.InstantTaskExecutorExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@ExtendWith(InstantTaskExecutorExtension::class)
class CredentialsValidationTest {
    @ParameterizedTest
    @CsvSource(
        "'email'",
        "'a@b.c'",
        "'aa@b.c'",
        "'ab@bc.c'",
        "'     '",
    )
    fun badEmail(email:String){
        val viewModel = SignupViewModel()
        viewModel.createAccount("email",":password:" , ":about:")
        assertEquals(SignupState.BadEmail , viewModel.signupState.value)
    }

    @Test
    fun badPassword(){
        val viewModel = SignupViewModel()
        viewModel.createAccount("ram@yahoo.com","" ,":about:")
        assertEquals(SignupState.BadPassword , viewModel.signupState.value)
    }
}