import { WebPlugin } from '@capacitor/core';
import type { AlertPluginPlugin } from './index';

export class AlertPluginWeb extends WebPlugin implements AlertPluginPlugin {
  async showAlert(options: { message: string }): Promise<void> {
    window.alert(options.message);
  }
}
