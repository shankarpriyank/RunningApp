package com.example.runningapp.ui.viewmodels.fragments

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.runningapp.R
import com.example.runningapp.others.Constants.REQUEST_CODE_LOCATION_PERMISSION
import com.example.runningapp.others.TrackingUtility
import com.example.runningapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_run.*
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


@AndroidEntryPoint
class RunFragment:Fragment(R.layout.fragment_run), EasyPermissions.PermissionCallbacks{
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestPermissions()








    }

    fun fabOnClick(){
        findNavController().navigate(R.id.action_runFragment_to_trackingFragment)
    }


    private fun requestPermissions()
    {
        if(TrackingUtility.hasLocationPermissions((requireContext()))){
            return
        }
          if (Build.VERSION.SDK_INT<Build.VERSION_CODES.Q){

              EasyPermissions.requestPermissions(
                  this,
                  "You Need To Accept Location Permission To Use This App",
                  REQUEST_CODE_LOCATION_PERMISSION,
                  Manifest.permission.ACCESS_COARSE_LOCATION,
                          Manifest.permission.ACCESS_FINE_LOCATION

              )
          }
        else{
              EasyPermissions.requestPermissions(
                  this,
                  "You Need To Accept Location Permission To Use This App",
                  REQUEST_CODE_LOCATION_PERMISSION,
                  Manifest.permission.ACCESS_COARSE_LOCATION,
                  Manifest.permission.ACCESS_FINE_LOCATION,
                          Manifest.permission.ACCESS_BACKGROUND_LOCATION

              )
          }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {}

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {

        if ( EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            AppSettingsDialog.Builder(this,).build().show()


        }

        else{
            requestPermissions()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults,this)
    }



}