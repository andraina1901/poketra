<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String fonction = String.valueOf(session.getAttribute("fonction")); %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Poketra</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
</head>

<body>
  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="assets/img/logo.png" alt="">
        <span class="d-none d-lg-block">Poketra</span>
      </a>
      <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <div class="search-bar">
      <form class="search-form d-flex align-items-center" method="POST" action="#">
        <input type="text" name="query" placeholder="Search" title="Enter search keyword">
        <button type="submit" title="Search"><i class="bi bi-search"></i></button>
      </form>
    </div><!-- End Search Bar -->

    <nav class="header-nav ms-auto">
      <ul class="d-flex align-items-center">

        <li class="nav-item d-block d-lg-none">
          <a class="nav-link nav-icon search-bar-toggle " href="#">
            <i class="bi bi-search"></i>
          </a>
        </li><!-- End Search Icon-->

        <li class="nav-item dropdown">

          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-bell"></i>
            <span class="badge bg-primary badge-number">4</span>
          </a><!-- End Notification Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
            <li class="dropdown-header">
              You have 4 new notifications
              <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-exclamation-circle text-warning"></i>
              <div>
                <h4>Lorem Ipsum</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>30 min. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-x-circle text-danger"></i>
              <div>
                <h4>Atque rerum nesciunt</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>1 hr. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-check-circle text-success"></i>
              <div>
                <h4>Sit rerum fuga</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>2 hrs. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="notification-item">
              <i class="bi bi-info-circle text-primary"></i>
              <div>
                <h4>Dicta reprehenderit</h4>
                <p>Quae dolorem earum veritatis oditseno</p>
                <p>4 hrs. ago</p>
              </div>
            </li>

            <li>
              <hr class="dropdown-divider">
            </li>
            <li class="dropdown-footer">
              <a href="#">Show all notifications</a>
            </li>

          </ul><!-- End Notification Dropdown Items -->

        </li><!-- End Notification Nav -->

        <li class="nav-item dropdown">

          <a class="nav-link nav-icon" href="#" data-bs-toggle="dropdown">
            <i class="bi bi-chat-left-text"></i>
            <span class="badge bg-success badge-number">3</span>
          </a><!-- End Messages Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
            <li class="dropdown-header">
              You have 3 new messages
              <a href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View all</span></a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="message-item">
              <a href="#">
                <img src="assets/img/messages-1.jpg" alt="" class="rounded-circle">
                <div>
                  <h4>Maria Hudson</h4>
                  <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                  <p>4 hrs. ago</p>
                </div>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="message-item">
              <a href="#">
                <img src="assets/img/messages-2.jpg" alt="" class="rounded-circle">
                <div>
                  <h4>Anna Nelson</h4>
                  <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                  <p>6 hrs. ago</p>
                </div>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="message-item">
              <a href="#">
                <img src="assets/img/messages-3.jpg" alt="" class="rounded-circle">
                <div>
                  <h4>David Muldon</h4>
                  <p>Velit asperiores et ducimus soluta repudiandae labore officia est ut...</p>
                  <p>8 hrs. ago</p>
                </div>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li class="dropdown-footer">
              <a href="#">Show all messages</a>
            </li>

          </ul><!-- End Messages Dropdown Items -->

        </li><!-- End Messages Nav -->

        <li class="nav-item dropdown pe-3">

          <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
            <img src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
            <span class="d-none d-md-block dropdown-toggle ps-2"><% out.print(fonction);%></span>
          </a><!-- End Profile Iamge Icon -->

          <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
            <li class="dropdown-header">
              <h6>Kevin Anderson</h6>
              <span>Web Designer</span>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                <i class="bi bi-person"></i>
                <span>My Profile</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                <i class="bi bi-gear"></i>
                <span>Account Settings</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
                <i class="bi bi-question-circle"></i>
                <span>Need Help?</span>
              </a>
            </li>
            <li>
              <hr class="dropdown-divider">
            </li>

            <li>
              <a class="dropdown-item d-flex align-items-center" href="#">
                <i class="bi bi-box-arrow-right"></i>
                <span>Sign Out</span>
              </a>
            </li>

          </ul><!-- End Profile Dropdown Items -->
        </li><!-- End Profile Nav -->

      </ul>
    </nav><!-- End Icons Navigation -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">
      
       <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>Insertion</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="charts-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="Look">
              <i class="bi bi-circle"></i><span>Look</span>
            </a>
          </li>
          <li>
            <a href="Dimension">
              <i class="bi bi-circle"></i><span>Dimension</span>
            </a>
          </li>
          <li>
            <a href="Type">
              <i class="bi bi-circle"></i><span>Type</span>
            </a>
          </li>
          <li>
            <a href="Unite">
              <i class="bi bi-circle"></i><span>Unite</span>
            </a>
          </li>
        </ul>
      </li><!-- End Charts Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#matiere" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>Matiere premiere</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="matiere" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="Matiere_premiere">
              <i class="bi bi-circle"></i><span>Matiere premiere</span>
            </a>
          </li>
          <li>
            <a href="Matiere_look">
              <i class="bi bi-circle"></i><span>Matiere look</span>
            </a>
          </li>
          <li>
            <a href="Recherche_matiere">
              <i class="bi bi-circle"></i><span>Matiere / look</span>
            </a>
          </li>
        </ul>
      </li>
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#model" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>Model</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="model" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="Model">
              <i class="bi bi-circle"></i><span>Ajout model</span>
            </a>
          </li>
          <li>
            <a href="Quantite_model">
              <i class="bi bi-circle"></i><span>Quantite Model</span>
            </a>
          </li>
          <li>
            <a href="Recherche_matiere_model">
              <i class="bi bi-circle"></i><span>Filtre par matiere</span>
            </a>
          </li>
          <li>
            <a href="Recherche_prix">
              <i class="bi bi-circle"></i><span>Recherche</span>
            </a>
          </li>
        </ul>
      </li><!-- End Charts Nav -->
      
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#fabrication" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>Fabrication</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="fabrication" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="Fournisseur">
              <i class="bi bi-circle"></i><span>Fournisseur</span>
            </a>
          </li>
          <li>
            <a href="Achat_matiere_premiere">
              <i class="bi bi-circle"></i><span>Achat Matière Première</span>
            </a>
          </li>
          <li>
            <a href="Fabrication">
              <i class="bi bi-circle"></i><span>Fabrication</span>
            </a>
          </li>
          <li>
            <a href="Liste_fabrication">
              <i class="bi bi-circle"></i><span>Liste</span>
            </a>
          </li>
        </ul>
      </li><!-- End Charts Nav -->
      
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#mouvement" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>Mouvement</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="mouvement" class="nav-content collapse " data-bs-parent="#sidebar-nav">
         
          <li>
            <a href="Entree">
              <i class="bi bi-circle"></i><span>Entree</span>
            </a>
          </li>
        </ul>
      </li><!-- End Charts Nav -->
      
       <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#benefice" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>Bénéfice</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="benefice" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="Metier">
              <i class="bi bi-circle"></i><span>Metier</span>
            </a>
          </li>
          <li>
            <a href="Salaire_metier">
              <i class="bi bi-circle"></i><span>Salaire Metier</span>
            </a>
          </li>
          <li>
            <a href="Nombre_taille">
              <i class="bi bi-circle"></i><span>Nombre Taille</span>
            </a>
          </li>
          <li>
            <a href="Taux_look">
              <i class="bi bi-circle"></i><span>Taux Look</span>
            </a>
          </li>
          <li>
            <a href="Metier_modele">
              <i class="bi bi-circle"></i><span>Metier modèle</span>
            </a>
          </li>
          <li>
            <a href="Prix_model">
              <i class="bi bi-circle"></i><span>Prix modèle</span>
            </a>
          </li>
          <li>
            <a href="Recherche">
              <i class="bi bi-circle"></i><span>Recherche</span>
            </a>
          </li>
          <li>
            <a href="Liste_benefice">
              <i class="bi bi-circle"></i><span>Liste</span>
            </a>
          </li>
        </ul>
      </li>
      
       <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#profil" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>Profil</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="profil" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          
          <li>
            <a href="Personne">
              <i class="bi bi-circle"></i><span>Personne</span>
            </a>
          </li>
          <li>
            <a href="Profil">
              <i class="bi bi-circle"></i><span>Profil</span>
            </a>
          </li>
          <li>
            <a href="Personne_embauche">
              <i class="bi bi-circle"></i><span>Personne Embauche</span>
            </a>
          </li>
          <li>
            <a href="Experience">
              <i class="bi bi-circle"></i><span>Experience</span>
            </a>
          </li>
          <li>
            <a href="Standard">
              <i class="bi bi-circle"></i><span>Standard</span>
            </a>
          </li>
          <li>
            <a href="Autres">
              <i class="bi bi-circle"></i><span>Autres</span>
            </a>
          </li>
          <li>
            <a href="Liste_profil_personne">
              <i class="bi bi-circle"></i><span>Liste</span>
            </a>
          </li>
        </ul>
      </li>
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#vente" data-bs-toggle="collapse" href="#">
          <i class="bi bi-bar-chart"></i><span>Vente</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="vente" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          
          <li>
            <a href="Vente">
              <i class="bi bi-circle"></i><span>Ajout</span>
            </a>
          </li>
          <li>
            <a href="Filtre_vente">
              <i class="bi bi-circle"></i><span>Filtre de vente</span>
            </a>
          </li>
        </ul>
      </li><!-- End Charts Nav -->
    </ul>

  </aside><!-- End Sidebar-->
