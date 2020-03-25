import java.io.ObjectStreamException;
import java.io.Serializable;
/*
* A java class that allows to create only one object per java is called Singleton.
*
* */
public class Singleton implements Serializable {
        private static Singleton INSTANCE;

        /**
         * Private constructor
         */
        private Singleton() {

        }

        /**
         * Static method for fetching the instance
         *
         * @return
         */
        public static Singleton getIntance() {
           /*Check whether instance is null or not*/
            if (INSTANCE == null) {
               /*Locking the class object*/
                synchronized (Singleton.class) {
                /*    Doing double check for the instance
                    This is required in case first time two threads simultaneously invoke
                    getInstance().So when another thread get the lock,it should not create the
                    object again as its already created by the previous thread.*/
                    if (INSTANCE == null) {
                        INSTANCE = new Singleton();
                    }
                }
            }
            return INSTANCE;
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }

    }

