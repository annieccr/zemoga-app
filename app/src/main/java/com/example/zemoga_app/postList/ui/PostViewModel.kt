package com.example.zemoga_app.postList.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostViewModel() : ViewModel (){
    private val _tabSelected = MutableLiveData<Int>()
    val tabSelected: LiveData<Int> = _tabSelected
    fun setTab (index:Int){
        _tabSelected.value = index
    }
    fun getTab (): Int? {
        return _tabSelected.value
    }
}