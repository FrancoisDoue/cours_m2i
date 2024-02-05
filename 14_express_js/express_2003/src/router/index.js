import { Router } from "express";
import userController from "../controllers/userController.js";
import { hashPassword } from "../../middlewares/bcrypt.js";
import { beforeLogin } from "../../middlewares/userControl.js";

const router = Router()

router.get('/', userController.getManyUsers)
// router.get('/:userEmail', userController.getUser)

router.post('/register', hashPassword, userController.register)
router.post('/login', beforeLogin, userController.login)

export default router;