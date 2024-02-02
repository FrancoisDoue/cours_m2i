import { Router } from "express";
import userController from "../controllers/userController.js";
import { hashPassword } from "../../middlewares/bcrypt.js";

const router = Router()

router.get('/', userController.getManyUsers)
router.get('/:username', userController.getUser)

router.post('/', hashPassword, userController.addUser)

export default router;