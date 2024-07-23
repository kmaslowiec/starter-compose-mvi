package com.example.startercomposemvi.main
//TODO use it as an example and replace with your tests
/*
import com.example.startercomposemvi.common.api.CallApi
import com.example.startercomposemvi.main.repository.MainRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MainRepositoryTest {

    private val callApi: CallApi by lazy { mockk() }
    private lateinit var mainRepository: MainRepository

    @BeforeEach
    fun setUp() {
        mainRepository = MainRepository(callApi)
    }

    @Test
    fun `getQuestions is successful WHEN request returns chatResponse`() {
        runTest {
            */
/*val chatResponse: ChatResponse = mockk()
            coEvery { callApi.getChatCompletions(any()) } returns chatResponse

            val result = mainRepository.getQuestions("request")

            assertNotNull(result.getOrNull())
            assertTrue(result.isSuccess)*//*

        }
    }

    @Test
    fun `getQuestions fails WHEN response throws exception`() {
        runTest {
           */
/* coEvery { callApi.getChatCompletions(any()) } throws Exception("")

            val result = mainRepository.getQuestions("request")

            assertNull(result.getOrNull())
            assertTrue(result.isFailure)*//*

        }
    }
}
*/
