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