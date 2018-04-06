package com.snakydesign.livedataextensions

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

/**
 * Created by Adib Faramarzi
 */
@Suppress("UNCHECKED_CAST")
class CreatingTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `test LiveData creation from value`(){
        val testingLiveData = just(2)
        val observer= Mockito.mock(Observer::class.java) as Observer<Int>
        assertEquals(2,testingLiveData.value)

        testingLiveData.observeForever(observer)
        Mockito.verify(observer).onChanged(2)
        Mockito.verifyNoMoreInteractions(observer)
    }

    @Test
    fun `test LiveData creation from function`(){
        val testingLiveData = from { 2 }
        val observer= Mockito.mock(Observer::class.java) as Observer<Int>
        assertEquals(2,testingLiveData.value)

        testingLiveData.observeForever(observer)
        Mockito.verify(observer).onChanged(2)
        Mockito.verifyNoMoreInteractions(observer)
    }
}