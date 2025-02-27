import Foundation
import Capacitor

@objc(AlertPlugin)
public class AlertPlugin: CAPPlugin {
    @objc func showAlert(_ call: CAPPluginCall) {
        guard let message = call.getString("message") else {
            call.reject("Message cannot be empty")
            return
        }
        
        DispatchQueue.main.async {
            let alertController = UIAlertController(title: nil, message: message, preferredStyle: .alert)
            alertController.addAction(UIAlertAction(title: "OK", style: .default) { _ in
                call.resolve()
            })
            
            self.bridge?.viewController?.present(alertController, animated: true)
        }
    }
}
