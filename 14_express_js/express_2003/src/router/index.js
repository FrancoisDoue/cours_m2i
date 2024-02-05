import { Router } from "express";
import userController from "../controllers/userController.js";
import { comparePassword, hashPassword } from "../../middlewares/bcrypt.js";
import { beforeLogin } from "../../middlewares/userControl.js";

const router = Router()

router.get('/', userController.getManyUsers)

router.post('/register', hashPassword, userController.register)
router.post('/login', [beforeLogin, comparePassword], userController.login)

router.put('/update/:id', hashPassword, userController.update)

router.delete('/delete/:id', userController.delete)

export default router;