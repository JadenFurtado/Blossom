var database = firebase.database();
//function to signup user
function writeUserData() {
   var provider = new firebase.auth.GoogleAuthProvider();
    firebase.auth().setPersistence(firebase.auth.Auth.Persistence.LOCAL);
    firebase.auth()
    .signInWithPopup(provider).then(function(result) {
       firebase.auth().currentUser.getIdToken(true).then(function(idToken) {
          console.log(firebase.auth().currentUser);
       }).catch(function(error) {
             });   
    }).catch(function(error) {
       var errorCode = error.code;
       var errorMessage = error.message;     
       console.log(error.code);
       console.log(error.message);
    });
      firebase.auth().onAuthStateChanged((user)=>{
         if(user){
            if(checkUserExists(user)!=true){
            firebase.database().ref('users/' + user.uid).set({
            username: user.displayName,
            email: user.email,
            profile_picture : user.photoURL
            });
            googleSignout();
            alert("successfully signed up!");
         }else{
            alert("user already signed up");
         }
      }else{
         location.replace("/selfHelpApp/profile.html");
      }
   });
}

var provider = new firebase.auth.GoogleAuthProvider();

//function checks if user exists
function checkUserExists(user){
var ref = firebase.database().ref("users/"+user.uid);
ref.once("value")
  .then(function(snapshot) {
    var a = snapshot.exists();  // true
    return a;
  });
}

//signin to the account
function googleSignin() {
   firebase.auth().setPersistence(firebase.auth.Auth.Persistence.LOCAL);
   firebase.auth()
   .signInWithPopup(provider).then(function(result) {
      firebase.auth().currentUser.getIdToken(true).then(function(idToken) {
         var user = firebase.auth().currentUser;
         if(checkUserExists(user)!=true){
            firebase.database().ref('users/' + user.uid).set({
            username: user.displayName,
            email: user.email,
            profile_picture : user.photoURL
            });
         }
         //var userExists = checkUserExists(user);
         /*
         if(userExists!=true){
            firebase.auth().signOut();
         }
         else{
            location.replace("http://127.0.0.1/firebase/profile.html");
         }
         */
         console.log(user);
      }).catch(function(error) {
  // Handle error
            });  
   
   }).catch(function(error) {
      var errorCode = error.code;
      var errorMessage = error.message;     
      console.log(error.code);
      console.log(error.message);
   });
}

//signout of account
function googleSignout() {
   firebase.auth().signOut()
   .then(function() {
      console.log('Signout Succesfull');
      location.replace("/selfHelpApp/index.html");
   }, function(error) {
      console.log('Signout Failed');  
   });
}