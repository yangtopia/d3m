import React from 'react';
import {AppRegistry, StyleSheet, Text, View} from 'react-native';

const HomeApp = () => {
    return (
        <View style={styles.container}>
            <Text style={styles.hello}>여기는 React Native!!</Text>
        </View>
    );
};

const DashboardApp = () => {
    return (
        <View style={styles.container}>
            <Text style={styles.hello}>Hello, World! This is Dashboard!</Text>
        </View>
    );
};

const NotificationApp = () => {
    return (
        <View style={styles.container}>
            <Text style={styles.hello}>Hello, World! This is Notification!</Text>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
    },
    hello: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
});

AppRegistry.registerComponent(
    'HomeApp',
    () => HomeApp,
);

AppRegistry.registerComponent(
    'DashboardApp',
    () => DashboardApp,
);

AppRegistry.registerComponent(
    'NotificationApp',
    () => NotificationApp,
);
