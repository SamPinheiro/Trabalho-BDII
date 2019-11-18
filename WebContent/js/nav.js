const navSlide = () => {
    const burguer = document.querySelector('.burguer');
    const nav = document.querySelector('.navLinks');
    const navLinks = document.querySelectorAll('.navLinks li')

    burguer.addEventListener('click', () => {
        nav.classList.toggle('nav-active');

        navLinks.forEach((link, index) => {
            if (link.style.animation) {
                link.style.animation = '';
            } else {
                link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7 + 0.3}s`;
            }
        });

        burguer.classList.toggle('toggle');
    });
}

navSlide();