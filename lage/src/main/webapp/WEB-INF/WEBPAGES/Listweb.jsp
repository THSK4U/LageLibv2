<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="metier.livers" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Livers</title>
    <link href="css/Style.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
    @charset "UTF-8";

*{
    margin: 0;
    padding: 0;
}

.background{
    background-color: #f4f4f9;
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
    left: 300px;
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
    left: 300px;
    top: 130px;
    width: 80%;
    height: 100%;
    gap: 20px;
    display: flex;
    flex-wrap: wrap;    
  }

  .livre{  
  	display: block;
    width: 170px;
    height: 316px;
    border-radius: 14px;
    align-content: space-around;
    transition: all ease-in-out .2s;
    cursor: pointer;
    cursor: url(https://www.top4top.me/do.php?imgf=top4top_meabbf497c1d0a1.png), auto !important;
  }
  .livre:hover{
    background-color: white;
  }
 
	.image{
    display: flex;
    justify-content: space-evenly;
	}
  .image img{
    width: 147px;
    height: 222px;
    border-radius: 14px;
  }
  .titre{
    display: flex;
    align-items: center;
    flex-direction: column;
    white-space:pre;
	overflow:hidden;
	text-overflow: ellipsis;
    margin-top: 5px;
    font-size: 14px;
    overflow:hidden;
    text-overflow: ellipsis;

  }
  
  .titre p{
    font-size: large;
    margin:0;
  }
  .titre a {
  color: #BFBFBF;
  font-size: 12px;
  
  }
  
.sidebar {
    width: 200px;
    height: 100%;
    background: #F6F3EE;
    color: white;
    position: fixed;
    left: 0;
    top: 0;
    overflow: auto;
    padding-top: 20px;
}

    .sidebar-link {
        display: flex;
        align-items: center;
        gab:20px;
        padding: 10px 20px;
        color: black;
        text-decoration: none;
        font-size: 18px;
    }

    .sidebar-link:hover {
    background: rgba(255, 255, 255, 0.2);
    color: black;
            text-decoration: none;
    }

    .sidebar-link .fas {
        margin-right: 10px;
    }

    .sidebar-logout {
        position: absolute;
        bottom: 20px;
        width: 100%;
        text-align: center;
    }

    .logout-button {
        padding: 10px 20px;
        background: #d9534f;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-decoration: none;
    }

    .logout-button:hover {
        background: #c9302c;
       color: white;
    }

    </style>
</head>
<body>
     <div class="sidebar">
        <a href="#" class="sidebar-link"><i class="fas fa-home"></i>Home</a>
        <a href="#" class="sidebar-link"><i class="fas fa-book"></i>Emprunter</a>
        <a href="#" class="sidebar-link"><i class="fas fa-heart"></i>Liste de souhaits</a>
        <a href="#" class="sidebar-link"><i class="fas fa-history"></i>Historique</a>
        <div class="sidebar-logout">
            <a href="/lage/" class="logout-button" >Log Out</a>
        </div>
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
        
        <div class="search">
            <input type="text" id="searchInput" class="search__input" placeholder="Trouvez votre livre...">
            <button class="search__button">
                <svg class="search__icon" aria-hidden="true" viewBox="0 0 24 24">
                    <g>
                        <path d="M21.53 20.47l-3.66-3.66C19.195 15.24 20 13.214 20 11c0-4.97-4.03-9-9-9s-9 4.03-9 9 4.03 9 9 9c2.215 0 4.24-.804 5.808-2.13l3.66 3.66c.147.146.34.22.53.22s.385-.073.53-.22c.295-.293.295-.767.002-1.06zM3.5 11c0-4.135 3.365-7.5 7.5-7.5s7.5 3.365 7.5 7.5-3.365 7.5-7.5 7.5-7.5-3.365-7.5-7.5z"></path>
                    </g>
               () </svg>
            </button>
        </div>
       <% List<livers> li = (List<livers>)request.getAttribute("Livre"); %>
       
        <div class="Livres">
  <% for(livers livre : li) { %>
        
            <div class="livre" onclick="redirectToNewPage('<%= livre.getId_livre() %>')"">
            
                <div class="image">
                    <img src="<%= livre.getImage() %>" alt="cover">
                </div>
                <div class="titre">                
                    <p><%= livre.getTitre() %></p>
                    <a><%= livre.getLauteur() %></a>
                </div>
               
            </div>
  <% } %>

        </div>
    </div>
    
</body>
 <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
    <script>
    function redirectToNewPage(id) {
        window.location.href = "Information?id=" + id;
    }
    const searchInput = document.getElementById("searchInput");
    searchInput.addEventListener("input", function() {
        searchLivres(searchInput.value.toLowerCase());
    });

    function searchLivres(query) {
        const livres = document.querySelectorAll('.livre');

        livres.forEach(livre => {
            const titre = livre.querySelector('.titre p').textContent.toLowerCase();
            const auteur = livre.querySelector('.titre a').textContent.toLowerCase();
            console.log(auteur);
            if (titre.includes(query) || auteur.includes(query)) {
                livre.style.display = 'block';
            } else {
                livre.style.display = 'none';
            }
        });
    }
    
    
    </script>
</html>