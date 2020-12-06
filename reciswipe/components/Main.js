/* eslint-disable prettier/prettier */
import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

const Main = () => (
  <View style={styles.container}>
    <Text>Hello World</Text>
  </View>
);

export default Main;


const styles = StyleSheet.create(
{
     container:{
       flex:1,
       backgroundColor: 'dodgerblue',
       alignItems: 'center'
     }
});