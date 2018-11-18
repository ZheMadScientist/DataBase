import {User} from "./user";
import {Content} from './content';
import {Tags} from './tags';

export class Review {
  user: User;
  content: Content;
  tags: Tags;
  reviewDate: string;

  constructor() {
    this.user = new User();
    this.content = new Content();
    this.tags = new Tags();
    this.reviewDate = '';
  }
}
