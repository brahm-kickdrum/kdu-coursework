import { Link, useLocation } from 'react-router-dom';
import { createUseStyles } from 'react-jss';

const useStyles = createUseStyles({
  dashboardNav: {
    margin: '2rem 0 0 0',
    fontSize: '1.4rem',
    display: 'flex',
  },
  explore: {
    margin: '0 0 0 2rem',
    color: 'black',
    borderBottom: '3px solid transparent', 
  },
  myWatchlist: {
    margin: '0 0 0 2rem',
    color: 'black',
    borderBottom: '3px solid transparent',
  },
  activeButton: {
    borderBottomColor: '#1976d2', 
  },
});

function DashboardNavBar() {
  const location = useLocation();
  const styles = useStyles();

  return (
    <div className={styles.dashboardNav}>
      <Link to="/" className={`${styles.explore} ${location.pathname === '/' ? styles.activeButton : ''}`}>
        Explore
      </Link>
      <Link to="/watchlist" className={`${styles.myWatchlist} ${location.pathname === '/watchlist' ? styles.activeButton : ''}`}>
        My Watchlist
      </Link>
    </div>
  );
}

export default DashboardNavBar;
