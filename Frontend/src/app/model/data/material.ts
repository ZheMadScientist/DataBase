import { Tags } from './tags';
import { Content } from './content';

export class Material {
  name: string;
  description: string;
  content: Content;
  tags: Tags;

  constructor() {
    this.name = '';
    this.description = '';
    this.content = new Content();
    this.tags = new Tags();
  }

}
