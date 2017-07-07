# MultiTouch-Android
Example of multi touch image for android (drag/zoom/rotate)

# CalendarEvent
Example Google API Calendar Event


For development you need to create or select project in the [GDC](https://console.developers.google.com/flows/enableapi?apiid=calendar)

*If you need get SHA1 to enable the API use on Windows:*
```
keytool -list -v -keystore "C:\Users\user_name\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android
```
*On unix:*
```
keytool -exportcert -alias androiddebugkey -keystore ~/.android/debug.keystore -list -v
```
