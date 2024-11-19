package com.example.viewmodelscope

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelscope.model.User
import com.example.viewmodelscope.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    private val repository = UserRepository()
    private var _users = MutableLiveData<List<User>?>()
    val users: LiveData<List<User>?>
        get() = _users

    init {
        getUserData()
    }

    fun getUserData(){
        viewModelScope.launch {
            var result: List<User>? = null
            withContext(Dispatchers.IO){
                result = repository.getUsers()
            }
            _users.value = result
        }
    }
}