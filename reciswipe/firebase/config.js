/* eslint-disable prettier/prettier */
/* eslint-disable eol-last */
import * as firebase from 'firebase';
import '@firebase/auth';
import '@firebase/firestore';

const firebaseConfig = {
  apiKey: 'AIzaSyC5koVcfcRgAx2WhkwzmiFI850xp5CkMAo',
  authDomain: 'ornate-grail-290507.firebaseapp.com',
  databaseURL: 'https://ornate-grail-290507.firebaseio.com',
  projectId: 'ornate-grail-290507',
  storageBucket: 'ornate-grail-290507.appspot.com',
  messagingSenderId: '398418108252',
  appId: '1:398418108252:web:d3a9a4b543ee7a0d4aeb99',
};

if (!firebase.apps.length) {
    firebase.initializeApp(firebaseConfig);
}

export { firebase };