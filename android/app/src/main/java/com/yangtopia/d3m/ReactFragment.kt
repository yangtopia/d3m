package com.yangtopia.d3m

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView


abstract class ReactFragment : Fragment() {
    private lateinit var reactRootView: ReactRootView
    private lateinit var reactInstanceManager: ReactInstanceManager
    private lateinit var bundle: Bundle

    abstract fun getMainComponentName(): String

    fun setReactInstanceManager(reactInstanceManager: ReactInstanceManager, bundle: Bundle) {
        this.reactInstanceManager = reactInstanceManager
        this.bundle = bundle
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        reactRootView = ReactRootView(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ReactRootView {
        super.onCreateView(inflater, container, savedInstanceState)
        return reactRootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reactRootView.startReactApplication(reactInstanceManager, getMainComponentName(), bundle)
    }

}