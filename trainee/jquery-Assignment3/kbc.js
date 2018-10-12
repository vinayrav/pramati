 var questions = [
   ["This place of worship belongs to which religion?", "[A]Bahai", "[B]Zoroastrianism", "[C]Jainism", "[D]Buddhism", "[A]"],
   ["In which of these sports would you normally see the referee running on the field?", "[A]Cricket.", "[B]Football", "[C]Basketball", "[D]Tennis", "[B]"],
   ["Which of these is a title given to the one who is a highly-skilled person or an expert?", "[A]Rahbar", "[B]Sahib", "[C]Faiz", "[D] Ustaad", "[D]"],
   ["Which of these national flags has the most number of stars on them?", "[A]USA", "[B]Brazil", "[C]Pakistan", "[D] Australia", "[A]"],
   [" By what name is the 24-day Salt March of March-April 1930 also known as?", "[A]Dilli Chalo", "[B]FarmersMarch", "[C]Jail Bharo Andolan", "[D]  Dandi March", "[D]"],
 ];
 score = 0;
 timer_flag = 0;
 checked = null;
 answer_flag = 0;

 function display_color() {
   checked = $('input[name=correctAnswer]:checked');
   if (checked.val() == questions[x][5]) {
     checked.parent().removeClass('bg-dark');
     checked.parent().addClass('bg-success');
     $('#submit').hide();
     answer_flag = 1;
   } else {
     checked.parent().removeClass('bg-dark');
     checked.parent().addClass('bg-danger');
     $('#submit').hide();
     answer_flag = 0;
   }
 }

 function initiator() {
   if (checked != null) {

     if (answer_flag == 1) {
       checked.parent().removeClass('bg-success');
       checked.parent().addClass('bg-dark');
     } else {
       checked.parent().removeClass('bg-danger');
       checked.parent().addClass('bg-dark');
     }
   }
   $('#submit').show();
   $('#start').hide();
   $("#a_radio").attr('disabled', false);
   $("#b_radio").attr('disabled', false);
   $("#c_radio").attr('disabled', false);
   $("#d_radio").attr('disabled', false);
   $(':radio').prop('checked', false);
   question_pick();

   id = setInterval(function() {
     myTimer()
   }, 1000);
   d = 5;

   function myTimer() {
     if (d >= 0)
       document.getElementById("timer").innerHTML = d--;
     else {
       if (tick <= 0) {
         d = 0;
         clearInterval(id);
         alert(score);
       } else if (tick > 0 && d < 0) {
         $('#submit').hide();
       }
     }
   }
 }

 function question_pick() {
   x = Math.floor(Math.random() * 4) + 1;
   $("#question").text(questions[x][0]);
   $("#option_a").text(questions[x][1]);
   $("#option_b").text(questions[x][2]);
   $("#option_c").text(questions[x][3]);
   $("#option_d").text(questions[x][4]);
 }

 function submit_button() {
   if (confirm("Press yes to submit the answer!")) {
     $('#next').show();
     display_color();
   } else {
     alert("submit it before the timer ends!");
   }
 }
 $(document).ready(function() {
   $('#submit').hide();
   $('#next').show();
   $("#start").on('click', function() {
     $('#submit').show();
     alert(score);
     tick = 3;

     initiator();
   });
   $("#next").on('click', function() {
     tick--;
     if (tick <= 0) {
       alert(score);
       clearInterval(id);
       alert("Quiz over");
     } else {
       clearInterval(id);
       initiator();
     }
   });
   $("#submit").on('click', function() {
     submit_button();
   });
 });
