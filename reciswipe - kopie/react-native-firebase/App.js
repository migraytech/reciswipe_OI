import 'react-native-gesture-handler';
import React, { useEffect, useState } from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createStackNavigator } from '@react-navigation/stack'
import { LoginScreen, HomeScreen, RegistrationScreen,DishScreen, LikedScreen } from './screens'
import { DefaultTheme, Title} from 'react-native-paper';
import { Card ,Header} from 'react-native-elements';

import { firebase} from './firebase/config'
import {decode, encode} from 'base-64'
import { View } from 'react-native';
if (!global.btoa) {  global.btoa = encode }
if (!global.atob) { global.atob = decode }

const Stack = createStackNavigator();

export default function App() {

  const [loading, setLoading] = useState(true)
  const [user, setUser] = useState(null)

  const theme = {
    ...DefaultTheme,
    roundness: 2,
    colors: {
      ...DefaultTheme.colors,
      primary: '#3498db',
      accent: '#f1c40f',
    },
  };
  
    useEffect(() => {
    const usersRef = firebase.firestore().collection('users');
     firebase.auth().onAuthStateChanged(user => {
      if (user) {
        usersRef
          .doc(user.uid)
          .get()
          .then((document) => {
            const userData = document.data()
            setLoading(false)
            setUser(userData)
          })
          .catch((error) => {
            setLoading(false)
          });
      } else {
        setLoading(false)
      }
    });
  }, []);

  if (loading) {
    return (
      <></>
    )
  }

  return (
    <NavigationContainer theme={theme}>
      <Stack.Navigator>
        { user ? (
          <Stack.Screen name="Home" options = {{title:"Reciswipe App"}} >
          {props => <HomeScreen {...props} extraData={user} />}
          </Stack.Screen>

        ) : (
          <>
            <Stack.Screen name="Login" component={LoginScreen} />
            <Stack.Screen name="Registration" component={RegistrationScreen} />

          </>
        )}
            <Stack.Screen name="DishScreen" component={DishScreen} options = {{title:"Time to eat this Dish"}}/>
            <Stack.Screen name="LikedScreen" options = {{title:"Your liked dishes"}} >
          {props => <LikedScreen {...props} extraData={user} />}
          </Stack.Screen>
      </Stack.Navigator>
    </NavigationContainer>
  );
}