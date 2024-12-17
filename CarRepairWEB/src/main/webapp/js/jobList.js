function getJobList(name, tableId){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
  if (this.readyState === 4 && this.status === 200) {
        document.getElementById(tableId).innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "jobList?name="+document.getElementById(name).value, true);
  xhttp.send();
}

function getAllJobList(tableId) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        document.getElementById(tableId).innerHTML = this.responseText;
    }
  };
  xhttp.open("GET", "jobList", true);
  xhttp.send();
}
function insertJob(name, surname, model, registration, mileage, tableId, errorInfo) {
    document.getElementById(errorInfo).innerHTML ="&nbsp;";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        
        console.log(this);
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
        if (this.readyState === 4 && this.status === 400) {
            document.getElementById(errorInfo).innerHTML = this.responseText;
        }   
        };
        var ar1 = document.getElementById(name).value;
        var ar2 = document.getElementById(surname).value;
        var ar3 = document.getElementById(model).value;
        var ar4 = document.getElementById(registration).value;
        var ar5 = document.getElementById(mileage).value;
  xhttp.open("GET", "jobListInsert?name=" + ar1 + "&surname=" + ar2 + "&model=" + ar3 + "&registration=" + ar4 + "&mileage=" + ar5, true);
  xhttp.send();
  }
  
  function updateJob(jobId, name, surname, model, registration, mileage, status, tableId, errorInfo) {
    document.getElementById(errorInfo).innerHTML ="&nbsp;";
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            document.getElementById(tableId).innerHTML = this.responseText;
        }
        if (this.readyState === 4 && this.status === 400) {
            document.getElementById(errorInfo).innerHTML = this.responseText;
        }
    };
  var ar1 = document.getElementById(name+jobId).value;
  var ar2 = document.getElementById(surname+jobId).value;
  var ar3 = document.getElementById(model+jobId).value;
  var ar4 = document.getElementById(registration+jobId).value;
  var ar5 = document.getElementById(mileage+jobId).value;
  var ar6 = document.getElementById(status+jobId).value;
  
  console.log("Job ID: " + jobId);
  console.log("Name: " + ar1);
  console.log("Surname: " + ar2);
  console.log("Model: " + ar3);
  console.log("Registration: " + ar4);
  console.log("Mileage: " + ar5);
  console.log("Status: " + ar6);
  
  xhttp.open("GET", "jobListUpdate?jobId="+jobId+"&name=" + ar1 + "&surname=" + ar2 + "&model=" + ar3 + "&registration=" + ar4 + "&mileage=" + ar5 + "&status=" + ar6, true);
  xhttp.send();
}
  
  function deleteJob(jobId, tableId, errorInfo){
      document.getElementById(errorInfo).innerHTML ="&nbsp;";
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                document.getElementById(tableId).innerHTML = this.responseText;
            }
            if (this.readyState === 4 && this.status === 400) {
                document.getElementById(errorInfo).innerHTML = this.responseText;
            }
        };

      xhttp.open("GET", "jobListDelete?id=" + jobId, true);
      xhttp.send();
  }