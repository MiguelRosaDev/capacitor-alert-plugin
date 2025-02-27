import { registerPlugin } from '@capacitor/core';

export interface AlertPluginPlugin {
  showAlert(options: { message: string }): Promise<void>;
}

const AlertPlugin = registerPlugin<AlertPluginPlugin>('AlertPlugin');

export { AlertPlugin };
