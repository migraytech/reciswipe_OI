/* eslint-disable prettier/prettier */
/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';

export { default as LoginScreen } from './LoginScreen/LoginScreen'

export { default as HomeScreen } from './HomeScreen/HomeScreen'

export { default as RegistrationScreen } from './RegistrationScreen/RegistrationScreen'
AppRegistry.registerComponent(appName, () => App);
