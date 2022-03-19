// Get a reference to the database service
var database = firebase.database();
var redirectURL = "/login.html";


//function to add a task to the user
function addTask(taskName){
  var today = new Date();
  var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
  firebase.auth().onAuthStateChanged((user)=>{
    if(user){
      var taskListRef = firebase.database().ref("users/"+user.uid+"/tasks");
      var newTaskRef = taskListRef.push();
      newTaskRef.set({
      taskName:taskName,
      taskDate:date,
      taskStatus:"false"
      });
    }else{
      location.replace(redirectURL);
    }
  });
}

//function to edit Tasks
function editTask(taskId,taskName){
  firebase.auth().onAuthStateChanged((user)=>{
    if(user){
      var taskListRef = firebase.database().ref("users/"+user.uid+"/tasks/"+taskId);
      var newTaskRef = taskListRef.push();
      newTaskRef.update({
        taskName:taskName,
        taskDate:date
      });
    }else{
      location.replace(redirectURL);
    }
  });
}

//function to get task list of the user
function getTaskList(){
  firebase.auth().onAuthStateChanged((user)=>{
    if(user){
      var tasksRef = firebase.database().ref("users/"+user.uid+"/tasks");
      tasksRef.on("value",function(snapshot){
        var taskList = snapshot.val();
        for(task in taskList){
          console.log(taskList[task]['taskName']);
          var tasks=document.getElementById("taskList");
          var newElement = document.createElement("div");
          newElement.id = "taskElement";
          newElement.addEventListener("click",editTask(task,));
          //newElement.setAttribute("data-task-id",task);
          newElement.textContent = taskList[task]['taskName'];
          tasks.appendChild(newElement);
        }
      },function(error){
        console.log("Error:"+error.code);
      });
    }else{
      location.replace(redirectURL);
    }
  });
}

//function to change the task status
function changeTaskStatus(taskId,taskStatus){
  firebase.auth().onAuthStateChanged((user)=>{
    if(user){
      var taskRef = firebase.database().ref("users/"+user.uid+"/tasks/"+taskId);
      taskRef.update({
        taskStatus:taskStatus
      });
    }else{
      location.replace(redirectURL);
    }
  });
}

//function to get tasks by status
function getTasksByStatus(status){
  firebase.auth().onAuthStateChanged((user)=>{
    if(user){
      var tasks = firebase.database().ref('users/'+user.uid+"/tasks/status").equalTo(status);
      tasks.on("value",function(snapshot){
        console.log(snapshot);
      });
    }
  });
}

//function to add journal entry
function addJournalEntry(content){
  firebase.auth().onAuthStateChanged((user)=>{
    if(user){
      var today = new Date();
      var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
      var contentRef = firebase.database().ref("users/"+user.uid+"/entries");
      var newRef = contentRef.push();
      newRef.set({
        Date:date,
        content:content,
      });
      alert("your entry has been saved!");
    }else{
      location.replace(redirectURL);
    }
  });
}

//function to return journal entries
function getJournalEntries(){
  firebase.auth().onAuthStateChanged((user)=>{
    if(user){
      var tasksRef = firebase.database().ref("users/"+user.uid+"/entries");
      tasksRef.on("value",function(snapshot){
        var taskList = snapshot.val();
        console.log(taskList);
      },function(error){
        console.log("Error:"+error.code);
      });
    }else{
      
    }
  });
}

//function to edit journal entries
function editJournalEntry(entryId,content){
  firebase.auth().onAuthStateChanged((user)=>{
    if(user){
      var today = new Date();
      var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
      var tasksRef = firebase.database().ref("users/"+user.uid+"/entries/"+entryId);
      tasksRef.update({
        Date:date,
        content:content
      });
    }else{
      location.replace(redirectURL);
    }
  });
}


