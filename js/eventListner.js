firebase.auth().onAuthStateChanged((user)=>{
 if(user){  
    console.log(user.uid); 
 }else{
    location.replace("/profile.html");
 }
});