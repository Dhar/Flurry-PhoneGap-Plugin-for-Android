# A Flurry phonegap plugin for Android

## Installation
First of all, follow the instructions described in [Flurry's website](http://support.flurry.com/index.php?title=Analytics/GettingStarted/Android) for native support. After you do that, do the following:

- Drag ***com/phonegap/plugins/flurry/Flurry.java*** into your ***src*** folder.
- Drag ***flurry.js*** into your phonegap's assets.
- Declare the plugin in ***res/xml/config.xml*** file. Inside the tag `<plugin>` add the following line:
`<plugin name="Flurry" value="com.phonegap.plugins.flurry.Flurry"/>`

And that's it!

## Usage
### The following examples are based on [official events documentation](http://support.flurry.com/index.php?title=Analytics/GettingStarted/Events/Android).

To log the event "Article_Read"

```javascript
window.plugins.flurry.logEvent('Article_Read')
```

To log an event "Article_Read" with some parameters as:  

- Author: John Q
- User_Status: Registered

```javascript
var params = {
    Author: 'John Q',
    User_Status: 'Registered'
};

window.plugins.flurry.logEvent('Article_Read', params);
```

## Credits
Created by [aio1108](https://github.com/aio1108)