package com.example.memorymaster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {
    private val _score = MutableLiveData<Int>().apply{value = 0} //Initialize and variable to zero
    val score: LiveData<Int>
        get() = _score

    fun increaseScore() {
        _score.value = (_score.value ?: 0) + 1
    }

    fun resetScore() {
        _score.value = 0
    }
}
