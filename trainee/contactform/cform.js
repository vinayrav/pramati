$(document).ready(function () {
  $("#datepicker").datepicker();

  $("#fname").keyup(function () {
    $('#fname').css('textTransform', 'capitalize');
  });
  $("#lname").keyup(function () {
    $('#lname').css('textTransform', 'capitalize');
  });

});

function val() {
  var i = 0;

  var flag = 0;
  var blankflag = 0;
  var fname = document.getElementById("fname").value;
  var lname = document.getElementById("lname").value;
  var email = document.getElementById("email").value;
  var number = document.getElementById("number").value;
  var dob = document.getElementById("datepicker").value;

  if (fname.length < 1) {
    document.getElementById("fname_error").innerHTML = "First Name cannot be blank";
    $("#fname_error").show();
    blankflag = 1;
    flag = 1;
  }
  if (lname.length < 1) {
    document.getElementById("lname_error").innerHTML = "Last Name cannot be blank";
    $("#lname_error").show();
    blankflag = 1;
    flag = 1;
  }

 
  if (email.length < 1) {

    document.getElementById("email_error").innerHTML = "Email cannot be blank";
    $("#email_error").show();
    blankflag = 1;
    flag = 1;
  }
  if (number.length < 1) {

    document.getElementById("number_error").innerHTML = "Phone Number cannot be blank";
    $("#number_error").show();
    blankflag = 1;
    flag = 1;
  }
 if (dob.length < 1) {
    document.getElementById("date_error").innerHTML = "DOB cannot be blank";
    $("#date_error").show();
    blankflag = 1;
    flag = 1;
  }

  if (blankflag == 0) {
    var today = new Date();
    var given = new Date(dob);
    if (given > today) {


      document.getElementById("date_error").innerHTML = "DOB cannot be future date";
      $("#date_error").show();
      flag = 1;
    }
    if (!(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email))) {
      flag = 1;
      document.getElementById("email_error").innerHTML = "Enter a valid email address";
      $("#email_error").show();

    }
    if (!(/^[a-zA-Z]/.test(email))) {
      flag = 1;
      document.getElementById("email_error").innerHTML = "Email address cannot start with numbers";
      $("#email_error").show();

    }

    if (!(number.length == 10)) {
      flag = 1;
      document.getElementById("number_error").innerHTML = "Invalid Phone Number";
      $("#number_error").show();

    }
    if (number.length == 10 && !(number.charAt(0) == '9' || number.charAt(0) == '8' || number.charAt(0) == '7' || number.charAt(0) == '6')) {
      flag = 1;
      document.getElementById("number_error").innerHTML = "Phone Number should start with 9,8,7,6";
      $("#number_error").show();

    }

  }

  if (flag == 0) {

    var tab = document.getElementById("form_details");
    var row = tab.insertRow(++i);
    var c1 = row.insertCell(0);
    var c2 = row.insertCell(1);
    var c3 = row.insertCell(2);
    var c4 = row.insertCell(3);
    var c5 = row.insertCell(4);
    fname = fname.charAt(0).toUpperCase() + fname.substring(1, fname.length);
    lname = lname.charAt(0).toUpperCase() + lname.substring(1, lname.length);
    c1.innerHTML = fname;
    c2.innerHTML = lname;
    c3.innerHTML = email;
    c4.innerHTML = number;
    c5.innerHTML = dob;
    document.getElementById("form").reset();
    $("#fname_error").hide();
    $("#lname_error").hide();
    $("#email_error").hide();
    $("#number_error").hide();
    $("#date_error").hide();

  }

}


