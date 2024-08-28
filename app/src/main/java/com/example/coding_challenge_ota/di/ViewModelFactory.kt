package com.example.coding_challenge_ota.di
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import javax.inject.Inject
//import javax.inject.Provider
//import javax.inject.Singleton
//import kotlin.reflect.KClass
//
//@Singleton
//class ViewModelFactory @Inject constructor(
//    private val creators: Map<KClass<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
//) : ViewModelProvider.Factory {
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        var creator: Provider<out ViewModel>? = creators[modelClass.kotlin]
//        if (creator == null) {
//            for ((key, value) in creators) {
//                if (modelClass.isAssignableFrom(key.java)) {
//                    creator = value
//                    break
//                }
//            }
//        }
//        return creator?.get() as T?
//            ?: throw IllegalArgumentException("unknown model class $modelClass")
//    }
//
//}