package com.yangtopia.d3m

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.facebook.react.PackageList
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactRootView
import com.facebook.react.common.LifecycleState


abstract class ReactFragment : Fragment() {
    private lateinit var reactRootView: ReactRootView
    private lateinit var reactInstanceManager: ReactInstanceManager
//    private var bundle: Bundle? = null

    abstract fun getModuleName(): String

//    fun setReactInstanceManager(reactInstanceManager: ReactInstanceManager, bundle: Bundle?) {
//        this.reactInstanceManager = reactInstanceManager
//        this.bundle = bundle
//    }

    override fun onDetach() {
        super.onDetach()
        reactRootView?.unmountReactApplication();
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val packages = PackageList(activity?.application).packages

        reactInstanceManager = ReactInstanceManager.builder()
            .setApplication(activity?.application)
            .setCurrentActivity(activity)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index")
            .addPackages(packages)
            .setUseDeveloperSupport(BuildConfig.DEBUG)
            .setInitialLifecycleState(LifecycleState.BEFORE_RESUME)
            .build();
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ReactRootView {
        super.onCreateView(inflater, container, savedInstanceState)
        reactRootView = ReactRootView(requireActivity())

        reactRootView.startReactApplication(
            reactInstanceManager,
            getModuleName(),
            savedInstanceState
        )

        return reactRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        reactRootView?.unmountReactApplication();
    }

}