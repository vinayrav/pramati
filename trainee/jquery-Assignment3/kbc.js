  var questions = [
    ["This place of worship belongs to which religion?", "[A]Bahai", "[B]Zoroastrianism", "[C]Jainism", "[D]Buddhism", "[A]"],
    ["In which of these sports would you normally see the referee running on the field?", "[A]Cricket.", "[B]Football", "[C]Basketball", "[D]Tennis", "[B]"],
    ["Which of these is a title given to the one who is a highly-skilled person or an expert?", "[A]Rahbar", "[B]Sahib", "[C]Faiz", "[D] Ustaad", "[D]"],
    ["Which of these national flags has the most number of stars on them?", "[A]USA", "[B]Brazil", "[C]Pakistan", "[D] Australia", "[A]"],
    [" By what name is the 24-day Salt March of March-April 1930 also known as?", "[A]Dilli Chalo", "[B]FarmersMarch", "[C]Jail Bharo Andolan", "[D]  Dandi March", "[D]"],
  ];

  function display_color() {
    $("#a_radio").attr('disabled', true);
    $("#b_radio").attr('disabled', true);
    $("#c_radio").attr('disabled', true);
    $("#d_radio").attr('disabled', true);
    clicked_flag = 0;
    if ($("#a_radio").prop('checked')) {
      clicked_flag = 1;
      if (questions[x][5] == "[A]") {
        $("#option_a").css('background-color', 'green');

      } else {
        $("#option_a").css('background-color', 'red');
      }
    }

    if ($("#b_radio").prop('checked')) {
      clicked_flag = 1;
      if (questions[x][5] == "[B]") {
        $("#option_b").css('background-color', 'green');

      } else {
        $("#option_b").css('background-color', 'red');
      }
    }
    if ($("#c_radio").prop('checked')) {
      clicked_flag = 1;
      if (questions[x][5] == "[C]") {
        $("#option_c").css('background-color', 'green');
      } else {
        $("#option_c").css('background-color', 'red');
      }
    }
    if ($("#d_radio").prop('checked')) {
      clicked_flag = 1;
      if (questions[x][5] == "[D]") {
        $("#option_d").css('background-color', 'green');
      } else {
        $("#option_d").css('background-color', 'red');
      }
    }
    if (clicked_flag == 0) {
      alert("You did not attempt this question");
    }
  }

  function initiator() {
    $("#a_radio").attr('disabled', false);
    $("#b_radio").attr('disabled', false);
    $("#c_radio").attr('disabled', false);
    $("#d_radio").attr('disabled', false);
    $("#option_a").css('background-color', 'MidnightBlue');
    $("#option_b").css('background-color', 'MidnightBlue');
    $("#option_c").css('background-color', 'MidnightBlue');
    $("#option_d").css('background-color', 'MidnightBlue');
    $(':radio').prop('checked', false);
    question_pick();
    alert(x);
    id = setInterval(function() {
      myTimer()
    }, 1000);
    var d = 7;

    function myTimer() {
      if (d >= 0)
        document.getElementById("timer").innerHTML = d--;
      else {
        if (tick <= 0) {
          d = 0;
          clearInterval(id);
          alert("quiz over");
        } else {

          display_color();
        }
      }
    }
  }

  function question_pick() {
    x = Math.floor(Math.random() * 4) + 1;
    $("#questions").text(questions[x][0]);
    $("#option_a").text(questions[x][1]);
    $("#option_b").text(questions[x][2]);
    $("#option_c").text(questions[x][3]);
    $("#option_d").text(questions[x][4]);
  }
  $(document).ready(function() {
    $("#start_quiz").on('click', function() {
      tick = 3;
      alert("Want to start?");
      initiator();
    });
    $("#next").on('click', function() {
      tick--;
      if (tick <= 0) {
        clearInterval(id);
        alert("quiz over");
      } else {
        clearInterval(id);
        initiator();
      }
    });
  });
