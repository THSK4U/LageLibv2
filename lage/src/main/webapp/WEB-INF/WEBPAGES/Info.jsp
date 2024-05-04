<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="metier.livers" %>
    <%@ page import="dao.LivresDaoimpli" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Livers</title>
    <link href="/index.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style >
    @charset "UTF-8";

*{
    margin: 0;
    padding: 0;
}

.background{
    background-color: rgb(248, 245, 240);
    position: absolute;
    width: 100%;
    height: 100%;
    z-index: -1;
    position: fixed;
}
.background img{
    transform: scaleX(-1);
    max-width: 687px;
    height: 100%;
    position: absolute;
    right: 0;
    opacity: 0.14;
}

 .sidebar {
    position: fixed;
    left: 0;
    top: 0;
    bottom: 0;
    width: 200px;
    background-color: #ffdba2;
    overflow-y: auto;
}

.nav-link {
    color: #000000 !important;
}
.nav-link:hover {
    background-color: #F8F5F0 !important;
    border-radius:20px 0 0 20px ;
    width: 100%;
}

.custom-shape-divider-bottom-1714556739 {
    position: absolute;
    width: 100%;
    overflow: hidden;
    line-height: 0;
    transform: rotate(90deg);
    top: 50px;
    right: 36%;
}

.custom-shape-divider-bottom-1714556739 svg {
    position: relative;
    display: block;
    width: calc(100% + 1.3px);
    height: 69px;
}

.custom-shape-divider-bottom-1714556739 .shape-fill {
    fill: rgb(248, 245, 240);
}

.search {
    position: absolute;
    left: 17%;
    top: 5%;
    width: 80%;
    display: flex;
    transform: scaleX(1);

  }
  
  .search__input {
    font-family: inherit;
    font-size: inherit;
    background-color: #ffffff;
    border: none;
    color: #646464;
    padding: 0.7rem 1rem;
    border-radius: 30px;
    width: 17em;
    transition: all ease-in-out .2s;
    margin-right: -2rem;
    box-shadow: 0 0 1em #0000000b;
  }
  
  .search__input:hover, .search__input:focus {
    box-shadow: 0 0 1em #0000002a;
  }
  
  .search__input:focus {
    outline: none;
    background-color: #f0eeee53;
  }
  
  .search__input::-webkit-input-placeholder {
    font-weight: 100;
    color: #ccc;
  }
  
  .search__input:focus + .search__button {
    background-color: #f0eeee53;
  }
  
  .search__button {
    border: none;
    background-color: transparent;
    margin-top: .1em;
    transition: all ease-in-out .2s;
  }
  
  .search__button:hover {
    cursor: pointer;
  }
  
  .search__icon {
    height: 1.3em;
    width: 1.3em;
    fill: #b4b4b4;
  }

  .Livres{
    position: absolute;
    left: 255px;
    top: 220px;
    width: 80%;
    height: 100%;
    display: flex;
    flex-wrap: wrap;
    background-color: white;
    border-radius: 30px;
  flex-direction: column;
  align-items: flex-end;
  justify-content: space-evenly;
  }

  .livre{
  	display: block;
    height: 316px;
    border-radius: 14px;
    align-content: space-around;
    transition: all ease-in-out .2s;
    cursor: pointer;
    display: flex;
    flex-direction: column;
  }
  .livre:hover{
    background-color: white;
  }
 
	.image{
    display: flex;
    justify-content: space-evenly;

	}
  .image img{
    width: 200px;
    height: 305px;
    
    position:absolute;
    border-radius: 14px;
    top:-170px;
  }
  .titre{
    position: absolute;
    top:-56px;
    left: 291px;
    display: flex;
    flex-direction: column;
  
  }
  
  .titre p{
    font-size: 3rem;
  }
  .dicsription{
    width: 76%;
    height: 100%;

  }
  .info{
    display: flex;
    gap: 30px;
    font-size: 1.5rem;
    margin: 40px;
  }
  .button{
      width: 220px;
      height: 80px;
      border: none;
      outline: none;
      font-size: 22px;
      border-radius: 40px;
      box-shadow: 0 6px 20px -5px rgba(0,0,0,0.4);
      overflow: hidden;
      cursor: pointer;
  }
  input{
    width: 100%;
      height: 80px;
      border: none;
      outline: none;
      background: #2f2f2f;
      color: #fff;
      text-align: center;
  }
  </style>
</head>
<body>
    
    <div class="sidebar">
        


        <h2 style="color: #f8f9fa;">Menu</h2>
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link Dashboard" href="Dashboard"><i class="fas fa-tachometer-alt"></i>Dashboard</a>
            </li>
            
            <li class="nav-item">
            <a class="nav-link collapsed List" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLivres" aria-expanded="false" aria-controls="collapseLayouts">
                               <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Livres
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLivres" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="List">Liste de livres</a>
                                    <a class="nav-link" href="new">Ajouter un livre</a>
                                </nav>
                            </div>
            </li>
            
            <li class="nav-item">
                <a class="nav-link collapsed List" href="#" data-bs-toggle="collapse" data-bs-target="#collapseMembers" aria-expanded="false" aria-controls="collapseLayouts">
                               <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Members
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseMembers" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="Member">Liste des membres</a>
                                    <a class="nav-link" href="Member/new">Ajouter un membre</a>
                                </nav>
                            </div>
            </li>
        </ul>
    </div>
    
    <!-- <div class="custom-shape-divider-bottom-1714556739">
        <svg data-name="Layer 1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1200 120" preserveAspectRatio="none">
            <path d="M1200,0H0V120H281.94C572.9,116.24,602.45,3.86,602.45,3.86h0S632,116.24,923,120h277Z" class="shape-fill"></path>
        </svg>
    </div> -->


    <div class="containe">
        <div class="background">
            <img src="https://mrkzgulfup.com/uploads/171466215535451.png" alt="booksback">
        </div>
        
         <% String idParam = request.getParameter("id"); %>
    <% if (idParam != null && !idParam.isEmpty()) { %>
        <% int id = Integer.parseInt(idParam); %>
        <% LivresDaoimpli dao = new LivresDaoimpli(); %>
        <% livers livre = dao.getLivres(id); %>
        <% if (livre != null) { %>
        <div class="Livres">
        
            <div class="livre">
                <div class="image">
                    <img src="<%= livre.getImage() %>" alt="cover">
                </div>  
                <div class="titre">
                    <p><%= livre.getTitre() %></p>
                </div>
                <button class="button">
                    <input class="styled" type="button" value="Emprunt" />
                </div>
                <div class="dicsription">
                    <div class="info">
                        <p><%= livre.getLauteur() %></p>
                        <p><%= livre.getLannéepublication() %></p>
                    </div>
                    <hr>
                    <p><%= livre.getDescription() %> </p>
                        <hr>
                        <div class="Ratings">
                            Ratings & Reviews
                            
                        </div>
                    </div>
                
            </div>

            <% } else { %>
            <p>Aucun Livre.</p>
        <% } %>
    <% } else { %>
        <p>Aucun ID.</p>
    <% } %>

        </div>
    </div>
    
</body>



</html>