<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8" />
  <title>Borrow Confirmation</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
  <form action="BorrowConfirmationServlet" method="post">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-xl">Extra large
      modal</button>

    <div class="modal fade bd-example-modal-xl" tabindex="-1" role="dialog" aria-labelledby="myExtraLargeModalLabel"
      aria-hidden="true">
      <div class="modal-dialog modal-xl">
        <div class="modal-content" style="background-color: #F2EEE9;">
          <img src="book.png" alt="book cover" style="height: 237px; width: 167px;">
          <br>
          <div>Book's Name</div>
          <br><br>
          <!-- Display member's information fetched from servlet -->
          <input type="text" placeholder="Member's full name" id="MemberName" name="MemberName" value="${member.nom_mb}" readonly><br><br>
          <input type="text" placeholder="Member's Phone number" id="MembersPhone" name="MembersPhone" value="${member.numérotéléphone}" readonly><br><br>
          <!-- You can adjust the date format as needed -->
          <input type="text" placeholder="Date Emprunt" id="DateEmprunt" name="DateEmprunt" value="<%= new java.util.Date() %>" readonly><br><br>
          <input type="text" placeholder="Date Retour" id="DateRetour" name="DateRetour"><br><br>

          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-primary">Confirm Info and Borrow</button>
          </div>
        </div>
      </div>
    </div>
  </form>
</body>

</html>
