package com.example.coroutine_testing

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test

class UtilTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()


    @Test
    fun getAddress() {
        val util = Util(mainCoroutineRule.testDispatcher)

        runTest {
            util.getAddress()
        }

    }

    @Test
    fun getUser() {

  val util = Util(mainCoroutineRule.testDispatcher)

        runTest {
            util.getUser()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            Assert.assertEquals(true,util.value)
        }

    }

    @Test
    fun getName(){
        val util = Util(mainCoroutineRule.testDispatcher)
        runTest {
            val result = util.getAddress()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            Assert.assertEquals("Delhi",result)
        }
    }


}