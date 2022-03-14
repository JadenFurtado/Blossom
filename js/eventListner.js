firebase.auth().onAuthStateChanged((user)=>{
 if(user){  
    console.log(user.uid); 
 }else{
    location.replace("http://127.0.0.1/firebase/profile.html");
 }
});