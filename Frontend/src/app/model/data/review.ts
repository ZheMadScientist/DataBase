import {Tags} from './tags';
import {Content} from './content';
import {User} from "./user";

export interface Review {
  GUID: number;
  user: User;
  content: Content;
  tags: Tags;
  reviewDate: string;
}
