$(document).ready(function () {
  $("#datepicker").datepicker({
    format: 'mm-dd-yyyy',
    endDate: '-1d',
    autoclose: true
  });
    $("#fname").keyup(function () {
    $('#fname').css('textTransform', 'capitalize');
  });
  $("#lname").keyup(function () {
    $('#lname').css('textTransform', 'capitalize');
  });
  $('#fname').focusout(function () {
    focus = 1;
    $('#fname_error').text("Invalid first name");
    if ($('#fname').val().length < 1 || !/^[a-zA-Z\' ']+$/.test($('#fname').val())) {
      $('#fname_error').show();
    } else {
      $('#fname_error').hide();
    }
  });
  $('#lname').focusout(function () {
    focus = 1;
    $('#lname_error').text("Invalid last name");
    if ($('#lname').val().length < 1 || !/^[a-zA-Z\' ']+$/.test($('#lname').val())) {
      $('#lname_error').show();
    } else {
      $('#lname_error').hide();
    }
  });
  $('#email').focusout(function () {
    focus = 1;
    $("#email_error").text("Invalid Email");
    if ($('#email').val().length < 1 || !/^([a-zA-Z]+[\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/.test($('#email').val())) {
      $("#email_error").show();
    } else {
      $("#email_error").hide();
    }
  });
  $('#number').focusout(function () {
    focus = 1;
    $("#number_error").text("Invalid Mobile Number");
    if ($('#number').val().length < 1 || !/^([6-9]+[/d]{9})?$/.test($('#number').val())) {
      $("#number_error").show();
    } else {
      $("#number_error").hide();
    }
  });
  $('#datepicker').focusout(function () {
    focus = 1;
    $('#date_error').text("Invalid date of birth");
    if ($('#datepicker').val().length < 1) {
      $('#date_error').show();
    } else {
      $('#date_error').hide();
    }
  });
    function capitalize(name) {
    var words = name.split(" ");
    final_name = "";
    var i = 0;
    for (i = 0; i < words.length; i++) {
      final_name += words[i].charAt(0).toUpperCase() + words[i].substring(1, words[i].length) + " ";
    }
    return final_name;
  }
  $('#button').click(function () {
    if ($("#fname_error").is(":visible") || $("#lname_error").is(":visible") || $("#email_error").is(":visible") || $("#number_error").is(":visible") || $("#date_error").is(":visible")) {
      error_flag = 1;
    } else {
      error_flag = 0;
    }
    if (error_flag == 0 && focus == 1) {
      $("#fname_error").hide();
      $("#lname_error").hide();
      $("#email_error").hide();
      $("#number_error").hide();
      $("#date_error").hide();
      var tab = $('#form_details');
      var first_name = capitalize($('#fname').val());
      var last_name = capitalize($('#lname').val());
      var email = $('#email').val();
      var phone_number = $('#number').val();
      var dob = $('#datepicker').val();
      tab.append("<tr ><td class='text-center' >" + first_name + "</td><td class='text-center'>" + last_name + "</td><td class='text-center'>" + email + "</td><td class='text-center' >" + phone_number + "</td><td class='text-center'>" + dob + "</td></tr>");
      $('#sample_form').trigger("reset");
      focus = 0
    } else if (focus == 0) {
      $('#fname_error').text("Invalid first name");
      $('#lname_error').text("Invalid last name");
      $("#email_error").text("Invalid Email");
      $("#number_error").text("Invalid Mobile Number");
      $('#date_error').text("Invalid date of birth");
      $("#fname_error").show();
      $("#lname_error").show();
      $("#email_error").show();
      $("#number_error").show();
      $("#date_error").show();
    } else if (error_flag == 1) {
      alert("clear the errors !");
    }
  });
});



