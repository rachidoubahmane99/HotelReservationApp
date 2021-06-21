<style><%@include file="../../Layout/Header.css"%></style>
  

<div class="nav">
  <input type="checkbox" id="nav-check">
  <div class="nav-header">
    <div class="nav-title">
      Hotel Reservation
    </div>
  </div>
  <div class="nav-btn">
    <label for="nav-check">
      <span></span>
      <span></span>
      <span></span>
    </label>
  </div>
  
  <div class="nav-links">
    <a href="/Home" target="_blank">Home</a>
    <a href="/MesReservation" target="_blank">Mes Reservation</a>
    <a href="#" target="_blank">Mon Profile</a>
    <a href="<%=request.getContextPath()%>/Logout" target="_blank">Logout</a>
  </div>
</div>
