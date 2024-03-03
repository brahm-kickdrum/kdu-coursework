import * as React from 'react';
import Snackbar, { SnackbarOrigin } from '@mui/material/Snackbar';
import Fade from '@mui/material/Fade';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from '../redux/store';
import { setShow } from '../redux/SnackBarSlice';
import { Alert } from '@mui/material';

export function TransitionsSnackbar() {
  const dispatch = useDispatch();
  const [open, setOpen] = React.useState(false);
  const [message, setMessage] = React.useState('');
  const [Transition, setTransition] = React.useState<typeof Fade>(Fade);

  interface State extends SnackbarOrigin {
    open: boolean;
  }

  const [state, setState] = React.useState<State>({
    open: false,
    vertical: 'bottom',
    horizontal: 'center',
  });
  const { vertical, horizontal } = state;

  const handleClose = () => {
    setOpen(false);
    dispatch(setShow(false));
  };

  const show = useSelector((state: RootState) => state.snackBar.show);
  const snackbarMessage = useSelector((state: RootState) => state.snackBar.message);
  const severity = useSelector((state: RootState) => state.snackBar.severity)

  React.useEffect(() => {
    if (show) {
      setMessage(snackbarMessage);
      setOpen(true);
    }
  }, [show, snackbarMessage]);

  return (
    <Snackbar
      anchorOrigin={{ vertical, horizontal }}
      open={open}
      onClose={handleClose}
      TransitionComponent={Transition}
      key={vertical + horizontal}
      autoHideDuration={1200}
    >
      <Alert severity={severity} variant='filled'>
        {message}
      </Alert>
    </Snackbar>
  );
}
