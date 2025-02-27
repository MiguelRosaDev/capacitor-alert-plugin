package com.example.plugin;

import android.app.AlertDialog;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "AlertPlugin")
public class AlertPlugin extends Plugin {

    @PluginMethod
    public void showAlert(PluginCall call) {
        String message = call.getString("message");
        
        if (message == null) {
            call.reject("Message cannot be empty");
            return;
        }

        getActivity().runOnUiThread(() -> {
            new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                    call.resolve();
                })
                .show();
        });
    }
}
